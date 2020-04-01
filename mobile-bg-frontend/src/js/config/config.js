let config = {};

// If there is no config.env.js file does not prevent execution to continue as default configurations will be loaded.
try {
    config = require('js/config/config.env')
} catch(error) {
    console.log(error);
    console.warn('Configuration file is missing (config.env.js in src/js/config)! Default configuration will be used!')
}

module.exports = {
    BASE_URL: 'http://95.169.219.170:8083/',
    WEB_SERVER_URL: 'http://95.169.219.170:8084/'
};
