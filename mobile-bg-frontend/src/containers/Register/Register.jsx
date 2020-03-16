import React, { useState } from 'react';
import { Link } from "react-router-dom";

// Components
import {Container, Box,Grid,TextField,Button,Typography}from '@material-ui/core';

// Styles && Images
import blurBG from '../../resources/background/carSideMIrror.jpg';
import '../Login/Login.scss'

// Actions && Redux
import { useDispatch} from 'react-redux';
import {registerUser} from './actions';

/**
 * Copyright text which is shown at the bottom of the form
 */
function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {'Copyright © Simple Cars'}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}


export default function SignUp() {
  const dispatch = useDispatch();
  /** Firstname state */
  const [firstName, setFirstname] = useState('');
  /** Lastname state */
  const [lastName, setLastname] = useState('');
  /** Username state */
  const [username, setUsername] = useState('');
  /** Password state */
  const [password, setPassword] = useState('');

  /** Method for updating the firstName state
   * @param {Object} event - Object which contains input field value
   */
  const onChangeFirstName = event => {
    setFirstname(event.target.value);
  };
  /** Method for updating the lastName state
   * @param {Object} event - Object which contains input field value
   */
  const onChangeLastname = event => {
    setLastname(event.target.value);
  };
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
  
   /** Creat register request and redirect 
   * @param {Object} event - Object which contain form event
   */
  const onSubmitCredentials = event => {
    event.preventDefault();
    dispatch(registerUser(username, password,firstName,lastName));
  };

  return (
  <div className='login-wrapper' style={{backgroundImage:"url(" + blurBG + ")"}}> 
    <Container className='container-wrapper' component="main" maxWidth="xs">
      <div className='div-wrapper'>
        <div className='paper'>
          <Typography className="form-title"  style={{marginBottom:'10px'}} component="h1" variant="h5">
            Sign up
          </Typography>
          <form onSubmit={onSubmitCredentials}  noValidate>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  margin="normal"
                  required
                  fullWidth
                  value={firstName}
                  onChange={onChangeFirstName}
                  id="firstname"
                  label="First name"
                  name="firstname"
                  autoComplete="firstname"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  margin="normal"
                  required
                  fullWidth
                  value={lastName}
                  onChange={onChangeLastname}
                  id="lastname"
                  label="Last name"
                  name="lastname"
                  autoComplete="lastname"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12}>
              <TextField
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={username}
                onChange={onChangeUsername}
                id="userName"
                label="Username"
                name="userName"
                autoComplete="userName"
                autoFocus
              />
              </Grid>
              <Grid item xs={12}>
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
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              className='login-button'
            >
              Sign Up
            </Button>
            <Grid container justify="center">
              <Grid item>
              <Link to={'/login'}>Already have an account? Sign in</Link>
              </Grid>
            </Grid>
          </form>
        </div>
        <Box  className="box-style" mt={8}>
          <Copyright />
        </Box>
      </div>
    </Container>
  </div>
  );
}