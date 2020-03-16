import { REMOVE_CAR_REQUEST } from './types.js';
import { removeCarSuccess, removeCarError } from './actions.js';
import { put, take, call } from 'redux-saga/effects';

/** Call removeCar */
export default function* removeCarSaga(api) {
  while (true) {
    const removeCarRequest = yield take(REMOVE_CAR_REQUEST);
    if (removeCarRequest.payload) {
      const {carId, userId, accessToken } = removeCarRequest.payload;
      yield call(removeCar, api,carId, userId, accessToken);
    }
  }
}

/** Create removeCar request
 * @return {any} Response message
 */
function* removeCar(api,carId, userId, accessToken) {
  var response;
  try {
    response = yield call(api.deleteCar, carId, userId, accessToken);
    console.log('response SAGA DELETE',response)
    yield put(removeCarSuccess(response.data));
  } catch (error) {
    console.log('error SAGA DELETE',error)
    yield put(removeCarError(error));
  }
}
