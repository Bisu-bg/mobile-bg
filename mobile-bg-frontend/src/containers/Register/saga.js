import { REGISTER_REQUEST } from './types.js';
// Actions
import { registerSuccess, registerError } from './actions.js';
import {loginUser} from '../Login/actions';
// Redux
import { put, take, call } from 'redux-saga/effects';

/** Call createUser with username,password,first and last name */
export default function* loginSaga(api) {
  while (true) {
    const registerRequest = yield take(REGISTER_REQUEST);
    if (registerRequest.payload) {
      const { username, password, firstName, lastName } = registerRequest.payload;
      yield call(createUser, api, username, password, firstName, lastName);
    }
  }
}

/** Create register request
 * @param {object} api - API providing access to the Cars backend
 * @param {string} username - Username of the user
 * @param {string} password - Password of the user
 * @param {string} firstName - First name of the user
 * @param {string} lastName - Last name of the user
 */
function* createUser(api, username, password, firstName, lastName) {
  var response;
  try {
    response = yield call(api.register, username, password, firstName, lastName);
    const successResponse = response.data;
    yield put(registerSuccess(successResponse.user, successResponse.userId, successResponse.firstName, successResponse.lastName));
    // Call login request 
    if(response){
      yield put(loginUser(username,password))
    }
  } catch (error) {
    yield put(registerError(error));
  }
}
