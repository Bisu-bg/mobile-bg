import { CREATE_CAR_REQUEST } from './types.js';
import { createCarSuccess, createCarError } from './actions.js';
import { put, take, call } from 'redux-saga/effects';

/** Call createCar  */
export default function* createCarSaga(api) {
  while (true) {
    const createCarRequest = yield take(CREATE_CAR_REQUEST);
    if (createCarRequest.payload) {
      const { 
        accessToken,
        city,
        color,
        condition,
        engineType,
        extras,
        gearBox,
        horsePower,
        id,
        make,
        mileage,
        model,
        price,
        user,
        year
      } = createCarRequest.payload;
      yield call(
        createCar,
        api,
        accessToken,
        city,
        color,
        condition,
        engineType,
        extras,
        gearBox,
        horsePower,
        id,
        make,
        mileage,
        model,
        price,
        user,
        year
      );
    }
  }
}

/** Create createCar request
 * @return {any} Object with updated car 
 */
function* createCar(api,accessToken,city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year) {
  var response;
  try {
    response = yield call(
      api.createCar,
      accessToken,
      city,
      color,
      condition,
      engineType,
      extras,
      gearBox,
      horsePower,
      id,
      make,
      mileage,
      model,
      price,
      user,
      year
      );
      console.log('CREATE CAR SAGA', response)
    yield put(createCarSuccess(response.data));
  } catch (error) {
    console.log('ERROR CREATE CAR SAGA', error)
    yield put(createCarError(error));
  }
}
