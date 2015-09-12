
# Works in the local development environment and when deployed.
# If successful, shows a single web page with the data sent to
# the jinja template is displayed in a Google Map. 

import os

import config
import ee
import jinja2
import webapp2

## for jinja

jinja_environment = jinja2.Environment(
    loader=jinja2.FileSystemLoader(os.path.dirname(__file__)))

##the main class

class MainPage(webapp2.RequestHandler):
  def get(self):                             # pylint: disable=g-bad-name
    """Request an image from Earth Engine and render it to a web page."""
    ee.Initialize(config.EE_CREDENTIALS, config.EE_URL)

    ##The data lookups for the three buckets.
    ## this one is for species, each of the names corresponds to a drop-down option
    ## in the index.html.
    ## The ones that are commented-out have malfunctioning fusion tables and 
    ## will probably require some research.
    ee_species_lookup = {
      "alabamaBeachMouse" : 'ft:11Vx9L_xbcxZ64_4i9mVichtKkmvhBHfnqFy9Dg91',
      "marbledMurrelet" : 'ft:10_xgBnrcGmFz5B-tmg_I04CaM0lXjHklEWFmyaHT',
      "alamedaWhipsnake" : 'ft:1sm6pbz-A2Xxrw-aE85p3Bw3o3MTho03cudi32neR',
      ##"caGnatcatcher" : 'ft:1VLIqV39Yv0eGz0R8t5qhUvx4bJnjdKOsrfxuHeAy',
      "redLegFrog" : 'ft:1W2yGcWl6LCuY4dEHWb-j4MkLqQEV3Ij8i_i1z3Rn',
      ##"desertTort" : 'ft:19RVwDWWbGnDIE2pEzsQ9Lg0f1TkiF9qW2LfI7Nfs',
      "snailKite" : 'ft:1YuzuBvzoE6UcpVSAdS1g0AluuHeal016Bdrt7QMa',
      "leastBell" : 'ft:1iKMkNm-RU2cRKouLGTqKjuhgYo5M5ExDGB8uVCpA',
      "kangarooRat" : 'ft:16eV2iIMWwgDdmmUlj6c0Bs2usKfqGMtpxugzQNjn',
      ##"topekaShiner" : 'ft:1NFhQcXJBT0l-wApSyPIv1syh0BBOnXW974vKvh_-',
      "none" : ""
    }

    ## this one is for the conservation data i.e. the US Pad data. I never could get oregon to work.
    ee_conservation_lookup = {
      "california" : 'ft:1XwMzNPolLF67-cJv4Fa61CcLryNcfhEIuFnURfVR',
      ##"oregon" : 'ft:1qLA1TJDNzt4XKMSk6sVxw0tCZn6yDFQhSFHzywa5',
      "none" : ""
    }

    ## This one is for the landcover data (aka "imperviousness")
    ee_landcover_lookup = {
      "NLCD2011" : "ft:1AMNsP57XaSl57UYTiKgz7hbDL10Je3qlu44LK6jY",
      "none" : ""
    }


    ##getting parameters


    species_key = self.request.get("species")
    if species_key in ["none", ""]: ##if noting is selected
        blank_image = ee.Image(0).mask(0)
        species_mapid = blank_image.getMapId()
    else: ## if something is selected, look up the species key using the lookup (above)
        species = ee.FeatureCollection(ee_species_lookup[species_key])
        species_mapid = species.getMapId()

    cons_key = self.request.get("conservation")
    if cons_key in ["none", ""]: ## if nothing is selected
        blank_image2 = ee.Image(0).mask(0)
        cons_mapid = blank_image2.getMapId()
    else: ## if something is selected, look up cons_key using the lookup (above)
        cons = ee.FeatureCollection(ee_conservation_lookup[cons_key])
        cons_mapid = cons.getMapId()

    lc_key = self.request.get("landcover")
    if lc_key in ["none", ""]: ## if nothing is slected
        blank_image3 = ee.Image(0).mask(0)
        lc_mapid = blank_image3.getMapId()
    elif lc_key in ["NLCD2011"]: ## if the landcover data is selected, make it look pretty
        lc = ee.FeatureCollection(ee_landcover_lookup[lc_key])
        image = ee.Image().byte().paint(lc,'MIICA11_P2').randomVisualizer()
        lc_mapid = image.getMapId()
    else: ## all other selections can be displayed in the normal way
        lc = ee.FeatureCollection(ee_landcover_lookup[lc_key])
        lc_mapid = lc.getMapId()




    # These could be put directly into template.render, but it
    # helps make the script more readable to pull them out here, especially
    # since this has been expanded to include more variables.

    template_values = {
        'species_mapid': species_mapid['mapid'], ##the mapid and token for species
        'species_token': species_mapid['token'],
        'cons_mapid': cons_mapid['mapid'],##the mapid and token for conservation
        'cons_token': cons_mapid['token'],
        'lc_mapid': lc_mapid['mapid'],## the mapid and token for landcover data
        'lc_token': lc_mapid['token']
        ## you could add more here if, someday someone wanted to add another bucket, you'll
        ## have to add another call in the map.html

    }
    ## adds everything to jinja
    template = jinja_environment.get_template('map.html')
    self.response.out.write(template.render(template_values))

app = webapp2.WSGIApplication([('/map.html', MainPage)], debug=True)
