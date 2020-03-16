import React, { useState } from 'react';
import { Link } from "react-router-dom";
// Components
import {Container, Typography, Box, Grid, TextField, Button } from '@material-ui/core'

// Styles && Images
import carMirrorImage from '../../resources/background/carSideMIrror.jpg';
import simpleCarLogo from '../../resources/cars.png';
import './Login.scss'

// Actions && Redux
import { useDispatch } from 'react-redux';
import { loginUser } from './actions.js';

/**
 * Copyright text which is shown at the bottom of the form
 */
function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {'Copyright ©    Simple Cars'}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

/**
 * Login Page 
 */
export default function LoginPage() {
  const dispatch = useDispatch();
  /** Username state */
  const [username, setUsername] = useState('');
  /** Password state */
  const [password, setPassword] = useState('');
  
  /** Method for updating the username state
   * @param {Object} event - Object which contains input field value
   */
  const onChangeUsername = event => {
    setUsername(event.target.value);
  };

  /** Method for updating the password state
   * @param {Object} event - Object which contains input field value
   */
  const onChangePassword = event => {
    setPassword(event.target.value);
  };
   /** Creat a login request and redirect 
   * @param {Object} event - Object which contain form event
   */

  const onSubmitCredentials = event => {
    event.preventDefault();
    dispatch(loginUser(username, password));
  };

  return (
    <div className='login-wrapper' style={{backgroundImage:"url(" + carMirrorImage + ")"}}> 
      <Container className='container-wrapper' component="main" maxWidth="xs">
        <div className='div-wrapper'>
          <div className='paper'>
            <Typography className="form-title" component="h1" variant="h5">
              Sign in
            </Typography>
            <form onSubmit={onSubmitCredentials}  noValidate>
              <TextField
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={username}
                onChange={onChangeUsername}
                id="email"
                label="Username"
                name="email"
                autoComplete="email"
                autoFocus
              />
              <TextField
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={password}
                onChange={onChangePassword}
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                className='login-button'
              >
                Sign In
              </Button>
              <Grid className="singIn-parent" container>
                <Grid className="signIn-link-wrapper" item>
                  <Link to={"/register"}>
                    {"Don't have an account?"}
                  </Link>
                  <Link to={"/cars"} style={{textAlign:'center'}} variant="body2">
                    {"Continue to catalog"}
                  </Link>
                </Grid>
              </Grid>
            </form>
          </div>
          <Box  className="box-style" mt={8}>
            <img style={{width:"200px"}} src={simpleCarLogo} alt="Logo" />
            <Copyright />
          </Box>
        </div>
      </Container>
    </div>
  );
}