import React from 'react';
import { useSelector } from 'react-redux';
// Router
import { Route, Switch, Redirect } from 'react-router-dom';
// Style
import './App.scss';
// Components
import LoginPage from '../../containers/Login/Login.jsx';
import RegisterPage from '../../containers/Register/Register.jsx';
import CustomRedirect from '../CustomRedirect/CustomRedirect.jsx';
import HomePage from '../../containers/Home/Home';

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
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/register" component={RegisterPage} />
        <Route exact path="/cars" component={HomePage} />
        <Redirect push exact from="/" to="/login" />
      </Switch>
    </div>
  );
}

export default App;
