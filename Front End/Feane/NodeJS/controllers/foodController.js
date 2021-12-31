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

router.get('/', (req, res) => {
    
});

module.exports = router;