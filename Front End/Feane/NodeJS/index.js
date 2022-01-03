const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
var createError = require('http-errors');
var logger = require('morgan');
var path = require('path');

var cookieParser = require('cookie-parser');
const { mongoose } = require('./db.js');
var menuController = require('./controllers/menuController');
var userController = require('./controllers/userController');

var app = express();
app.use(bodyParser.json());
app.use(cors({
    origin:['http://localhost:4200','http://127.0.0.1:4200'],
    credentials:true
  }));
app.listen(3000, () => console.log('Server started at port : 3000'));

app.use('/menu', menuController);
app.use('/users', userController);


//food controller
var foodController = require('./controllers/foodController');
app.use('/food', foodController);

//passport
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
 
  app.use(passport.initialize());
  app.use(passport.session());

 // view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'hbs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));



// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});




  