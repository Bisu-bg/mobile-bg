import { LOGOUT_REQUEST } from './types.js';
import { logoutSuccess, logoutError } from './actions.js';
import { put, take, call } from 'redux-saga/effects';
import { redirect } from '../CustomRedirect/actions';

/** If detect type: LOGOUT_REQUEST call logoutUser() */
export default function* logoutSaga(api) {
  while (true) {
    const logoutAction = yield take(LOGOUT_REQUEST);
    const accessToken = logoutAction.payload.accessToken;
    yield call(logoutUser, api, accessToken);
  }
}

/** Logout user */
function* logoutUser(api) {
  try {
    console.log('LOGOUT SAGA')
    yield put(logoutSuccess());
    yield put(redirect('/login'));
  } catch (error) {
    yield put(logoutError(error));
  }
}
