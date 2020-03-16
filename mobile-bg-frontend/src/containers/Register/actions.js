import { REGISTER_REQUEST, REGISTER_SUCCESS, REGISTER_ERROR } from './types';

/** Action which accepts username,password,firstName and lastName parameters.
   * @param {string} username - Username of the current user
   * @param {string} password - Password of the current user
   * @param {string} firstName - First name of the current user
   * @param {string} lastName - Last name of the current user
   * @return {object}  with accessToken,and user info
   */
export function registerUser(username, password, firstName, lastName) {
  return {
    type: REGISTER_REQUEST,
    payload: {
      username,
      password,
      firstName,
      lastName,
    },
  };
}

/** On successfully register set user info and token to store .
   * @param {string} username - Username of the current user
   * @param {Number} userId - Id of the user
   * @package {string} firstName - Name of the user
   * @package {string} lastName - Last name of the user
   * @return {any} accessToken Token and info for the user
   */
export function registerSuccess(username, userId, firstName,lastName) {
  return {
    type: REGISTER_SUCCESS,
    payload: {
      username,
      userId,
      firstName,
      lastName
    },
  };
}

/** On unsuccessfully register update store and show error message .
   * @param {string} errorMessage - Error message
   */
export function registerError(errorMessage) {
  return {
    type: REGISTER_ERROR,
    payload: errorMessage,
  };
}
