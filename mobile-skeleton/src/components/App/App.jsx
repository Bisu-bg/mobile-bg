import React from 'react';
import { useSelector } from 'react-redux';
// Router
import { Route, Switch, Redirect } from 'react-router-dom';
// Style
import './App.scss';
// Components
import Home from '../../containers/Home/Home';
import CustomRedirect from '../CustomRedirect/CustomRedirect';
// TODO: IMPORT PAGES TO WHICH USER WILL BE REDIRECT

function App() {
  const userSessionInfo = useSelector(state => state.userSession);
  const isUserLoggedIn = userSessionInfo.isLoggedIn;

  let windowLocation = window.location;
  let windowURL = windowLocation.pathname;

  return (
    <div className="App">
      <CustomRedirect />
      {isUserLoggedIn && (windowURL === '/login' || windowURL === '/register') ? (
        <Redirect to="/cars" />
      ) : null}
      <Switch>
        {
        // TODO: Set route-s 
        // 'home' is just for the example 
        }
        <Route exact path="/home" component={Home} />
        <Redirect push exact from="/" to="/home" />
      </Switch>
    </div>
  );
}

export default App;

