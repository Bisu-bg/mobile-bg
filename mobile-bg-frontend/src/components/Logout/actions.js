 import { LOGOUT_REQUEST, LOGOUT_SUCCESS, LOGOUT_ERROR } from './types';

/** Action for logout the user.
 * @param {string} accessToken - User access token
 * @return {Object} Return object
 */
export function logoutUser(accessToken) {
  return {
    type: LOGOUT_REQUEST,
    payload: {
      accessToken
    }
  };
}

/** Logout the user*/
export function logoutSuccess() {
  return {
    type: LOGOUT_SUCCESS,
  };
}

/** Handle error
 * @param {string} errorMessage - Error message
 */
export function logoutError(errorMessage) {
  return {
    type: LOGOUT_ERROR,
    payload: errorMessage,
  };
}
