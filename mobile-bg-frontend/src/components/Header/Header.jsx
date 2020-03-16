import React from 'react';
import {IconButton,Typography,Toolbar,AppBar,makeStyles} from '@material-ui/core';
import LogoutButton from '../Logout/LogoutButton';
import LoginButton from '../LoginButton/LoginButton';
import { useSelector } from 'react-redux';

// Styles && Images
import simpleCarLogo from '../../resources/cars.png';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function ButtonAppBar() {
  const classes = useStyles();
  const { currentUser } = useSelector(state => state.userSession);

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
           <img style={{width:"200px"}} src={simpleCarLogo} alt="Logo" />
          </IconButton>
          <Typography variant="h6" className={classes.title}>
            
          </Typography>
          {currentUser ?
            <div>
              <h4>Hello, {currentUser}</h4>
              <LogoutButton/>
            </div> 
          : <LoginButton/>
         }
        </Toolbar>
      </AppBar>
    </div>
  );
}
