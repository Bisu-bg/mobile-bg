import { LOGIN_REQUEST, LOGIN_SUCCESS, LOGIN_ERROR } from './types';

/** Action which accepts username and password parameters.
   * @param {string} username - Username of the current user
   * @return {any} password Password of the current user
   */
export function loginUser(username, password) {
  return {
    type: LOGIN_REQUEST,
    payload: {
      username: username,
      password: password,
    },
  };
}

/** On successfully login set username and token to store .
   * @param {string} username - Username of the current user
   * @param {string} accessToken - Username of the current user
   * @param {Number} userId - Id of the user)
   * @return {any} accessToken Token of the current user
   */
export function loginSuccess(username, userId, accessToken, firstName, lastName) {
  return {
    type: LOGIN_SUCCESS,
    payload: {
      accessToken,
      username,
      userId,
      firstName, 
      lastName
    },
  };
}

/** On unsuccessfully login update store and show error message .
   * @param {string} errorMessage - Error message
   */
export function loginError(errorMessage) {
  return {
    type: LOGIN_ERROR,
    payload: errorMessage,
  };
}
