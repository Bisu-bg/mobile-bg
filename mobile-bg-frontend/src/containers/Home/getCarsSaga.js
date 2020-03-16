import { GET_CARS_REQUEST } from './types.js';
import { getCarsSuccess, getCarsError } from './actions.js';
import { put, take, call } from 'redux-saga/effects';

/** Call getAllCars */
export default function* getCarsSaga(api) {
  while (true) {
    const getAllCarsRequest = yield take(GET_CARS_REQUEST);
    yield call(getAllCars, api);
  }
}

/** Create getCars request
 * @return {any} Object with all cars
 */
function* getAllCars(api) {
  var response;
  try {
    response = yield call(api.getCars);
    yield put(getCarsSuccess(response.data));
  } catch (error) {
    yield put(getCarsError(error));
  }
}
