const express = require('express');
var router = express.Router();
var ObjectId = require('mongoose').Types.ObjectId;
var { Food } = require('../models/food');



// localhost:3000/food/
router.get('/', (req, res) => {
         Food.find((err,docs)=>{
     if (!err) { res.send(docs); }
     else { console.log('Error in Retriving food :' + JSON.stringify(err, undefined, 2)); }

   });
});

router.post('/', (req, res) => {
    var food = new Food ({
        code : req.body.code,
        libelle : req.body.libelle  ,
        prix :req.body.prix,
        image : req.body.image,
        
    });
    food.save((err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in saving food :' + JSON.stringify(err, undefined, 2)); }
    });
});

module.exports = router;