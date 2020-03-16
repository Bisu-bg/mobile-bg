import { all } from 'redux-saga/effects';
// Saga
import loginSaga from '../containers/Login/saga.js';
import registerSaga from '../containers/Register/saga.js';
import getCarsSaga from '../containers/Home/getCarsSaga.js';
import editCarsSaga from '../containers/Home/editCarSaga.js';
import deleteCarsSaga from '../containers/Home/deleteCarSaga.js';
import createCarSaga from '../containers/Home/createCarSaga.js';
import logoutSaga from '../components/Logout/saga';
// API
import { api as loginApi } from '../api/carsBackend/loginApi';
import { api as editCarApi } from '../api/carsBackend/editCarApi';
import { api as createCarApi } from '../api/carsBackend/createCarApi';
import { api as getCarsApi } from '../api/carsBackend/getCarsApi';
import { api as registerApi } from '../api/carsBackend/registerApi';
import { api as removeCarApi } from '../api/carsBackend/removeCarApi';
import { api as logoutApi } from '../api/carsBackend/logoutApi';
/** Root saga.
 * @return {Object} - return store
 */
function* rootSaga() {
  yield all([
    loginSaga(loginApi),
    registerSaga(registerApi),
    editCarsSaga(editCarApi),
    getCarsSaga(getCarsApi),
    deleteCarsSaga(removeCarApi),
    createCarSaga(createCarApi),
    logoutSaga(logoutApi),

  ]);
}

export default rootSaga;
