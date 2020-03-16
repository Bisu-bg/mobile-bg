import React from 'react';
import { useDispatch } from 'react-redux';
import { redirect } from '../CustomRedirect/actions';
import { Button } from '@material-ui/core';
import { Link } from "react-router-dom";

/** Login Button component */
function LoginButton() {
  const dispatch = useDispatch();

  /** Redirect user to login screen */
  const onLoginClick = () => {
    dispatch(redirect('/login'));
  };

  return (
    <Link to={"/login"}>
        <Button onClick={onLoginClick}>
         Login
      </Button>
    </Link>
  );
}

export default LoginButton;