const mongoose = require('mongoose');

var Menu = mongoose.model('Menu', {
    titre: { type: String },
    code: { type: String },
    
});
module.exports = { Menu };
