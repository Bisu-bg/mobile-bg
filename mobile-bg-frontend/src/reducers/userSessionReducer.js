import { LOGIN_SUCCESS, LOGIN_ERROR } from '../containers/Login/types';
import {LOGOUT_SUCCESS } from '../components/Logout/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  loginError: '',
  currentUser: false,
  isLoggedIn: false,
  userId: null,
  accessToken:null,
  firstName:'',
  lastName:'',
};

/** User session reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function userSessionReducer(state = initialState, action) {
  switch (action.type) {
    
    /** Action Creator - login 
    * it will receive username and token dispatching from the saga
    */
    case LOGIN_SUCCESS:
      return {
        ...state,
        currentUser: action.payload.username,
        userId:action.payload.userId,
        firstName:action.payload.firstName,
        lastName:action.payload.lastName,
        accessToken: action.payload.accessToken,
        isLoggedIn: true,
        loginError: '',
      };

    /** Action Creator - Login failed 
    * it will receive the error message  dispatching from the saga
    */
    case LOGIN_ERROR:
      return {
        ...state,
        loginError: action.payload,
        currentUser: false,
        isLoggedIn: false,
        userId: null,
        accessToken:null,
        firstName:'',
        lastName:'',
      };

    /** Action Creator - logout
    * it will receive empty data  dispatching from the saga
    */
    case LOGOUT_SUCCESS:
      return {
        ...state,
        loginError: '',
        currentUser: false,
        isLoggedIn: false,
        userId: null,
        accessToken:null,
        firstName:'',
        lastName:'',
      };

    default:
      return state;
  }
}

export default userSessionReducer;
