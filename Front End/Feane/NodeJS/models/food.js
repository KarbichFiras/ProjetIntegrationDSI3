const mongoose = require('mongoose');
var Food = mongoose.model('Food', {
    code : { type: BigInt },
    libelle  : { type: String },
    prix : { type: Number },
    image : { type: String },
    
});
module.exports = { Food };