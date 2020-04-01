const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const path = require('path');
const morgan = require('morgan');

const app = express();

// We do not need to stop the execution if the file is missing because default configuration is loaded later.
let config = {};
try {
  config = require('./src/js/config/config.env')
} catch(error) {
  console.log(error);
  console.warn('Configurations are missing (config.env.js in src/js/config)! Default configurations will be used.')
}


// Logger =========================================================================
app.use(morgan('combined'));
app.use(express.static(path.join(__dirname, 'build')))


// Express Middlewares =========================================================================
// File upload makes the files by the client available under req.files

/*// JSON Parser
app.use(bodyParser.json());
// Parse URL encoded data
app.use(bodyParser.urlencoded({ extended: true }));*/
// Define cors politics
app.use(
  cors({
    origin: 'http://95.169.219.170:8084',
    optionsSuccessStatus: 200
  })
);

app.get('/*', function(req, res) {
    res.sendFile(path.join(__dirname, 'build', 'index.html'))
});



// App starts =========================================================================
// app.listen(config.WEB_SERVER_PORT)

const port = config.WEB_SERVER_PORT ? config.WEB_SERVER_PORT : 8084;

app.listen(port);

console.log(`App listens to port ${port}...`);
