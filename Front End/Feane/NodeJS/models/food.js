const mongoose = require('mongoose');
var Food = mongoose.model('Food', {
    code : { type: String },
    libelle  : { type: String },
    prix : { type: Number },
    image : { type: String },
    
});
module.exports = { Food };