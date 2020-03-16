import { EDIT_CAR_REQUEST } from './types.js';
import { editCarSuccess, editCarError } from './actions.js';
import { put, take, call } from 'redux-saga/effects';

/** Call editCar  */
export default function* getCarsSaga(api) {
  while (true) {
    const editCarRequest = yield take(EDIT_CAR_REQUEST);
    if (editCarRequest.payload) {
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
      } = editCarRequest.payload;

      console.log('dada',accessToken,
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
      year)
      yield call(
        editCar,
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

/** Create editCar request
 * @return {any} Object with updated car 
 */
function* editCar(api,accessToken,city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year) {
  var response;

  try {
    response = yield call(
      api.editCar,
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
    yield put(editCarSuccess(response.data));
  } catch (error) {
    yield put(editCarError(error));
  }
}
