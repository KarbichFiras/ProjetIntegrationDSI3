const express = require('express');
var router = express.Router();
var ObjectId = require('mongoose').Types.ObjectId;
var { Food } = require('../models/food');



// localhost:3000/food/
//get
router.get('/', (req, res) => {
         Food.find((err,docs)=>{
     if (!err) { res.send(docs); }
     else { console.log('Error in Retriving food :' + JSON.stringify(err, undefined, 2)); }

   });
});
//post
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
//get by id
router.get('/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send(`No record with given id : ${req.params.id}`);

    Food.findById(req.params.id, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in Retriving food :' + JSON.stringify(err, undefined, 2)); }
    });
});
//update 
router.put('/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send(`No record with given id : ${req.params.id}`);

        var food = {
            code : req.body.code,
            libelle : req.body.libelle  ,
            prix :req.body.prix,
            image : req.body.image,
        };
    Food.findByIdAndUpdate(req.params.id, { $set: food }, { new: true }, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in Food Update :' + JSON.stringify(err, undefined, 2)); }
    });
});
//delete

router.delete('/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send(`No record with given id : ${req.params.id}`);

        Food.findByIdAndRemove(req.params.id, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in Food Delete :' + JSON.stringify(err, undefined, 2)); }
    });
});
module.exports = router;