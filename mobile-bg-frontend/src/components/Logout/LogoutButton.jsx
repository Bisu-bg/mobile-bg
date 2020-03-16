import React from 'react';
import { useDispatch } from 'react-redux';
import { logoutUser } from './actions.js';
import { Button } from '@material-ui/core';

/** Logout Button component */
function LogoutButton() {
  const dispatch = useDispatch();

  /** Logout the user and redirect to home */
  const onLogoutClicked = () => {
    dispatch(logoutUser());
  };

  return (
    <Button onClick={onLogoutClicked}>
      Logout
    </Button>
  );
}

export default LogoutButton;