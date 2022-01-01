const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const { mongoose } = require('./db.js');
var menuController = require('./controllers/menuController');
var userController = require('./controllers/userController');

var app = express();
app.use(bodyParser.json());
app.use(cors({
    origin:['http://localhost:59527','http://127.0.0.1:59527'],
    credentials:true
  }));
app.listen(3000, () => console.log('Server started at port : 3000'));

app.use('/menu', menuController);
app.use('/users', userController);


//food controller
var foodController = require('./controllers/foodController');
app.use('/food', foodController);


var passport = require('passport');
var session = require('express-session');
app.use(session({
    name:'myname.sid',
    resave:false,
    saveUninitialized:false,
    secret:'secret',
    cookie:{
      maxAge:36000000,
      httpOnly:false,
      secure:false
    },
  }));

 require('./passport-config');
  app.use(passport.session());
  app.use(passport.initialize());