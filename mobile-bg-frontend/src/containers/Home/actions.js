import { 
  GET_CARS_REQUEST, GET_CARS_SUCCESS, GET_CARS_ERROR, 
  REMOVE_CAR_REQUEST, REMOVE_CAR_SUCCESS, REMOVE_CAR_ERROR,
  EDIT_CAR_REQUEST, EDIT_CAR_SUCCESS, EDIT_CAR_ERROR,
  CREATE_CAR_REQUEST, CREATE_CAR_SUCCESS, CREATE_CAR_ERROR,
} from './types';

// -------------- GET_CARS_REQUEST -------------- 

/** Action to get all cars.
   * @return {any} Array of objects with all cars
   */
export function getCars() {
  return {
    type: GET_CARS_REQUEST
  };
}

/** On successfully getCars set car object to store .
   * @param {object} cars - Object with cars
   * @return {any} All cars
   */
export function getCarsSuccess(cars) {
  return {
    type: GET_CARS_SUCCESS,
    payload: {
      cars
    },
  };
}

/** On unsuccessfully getCars update store and show error message .
   * @param {string} errorMessage - Error message
   */
export function getCarsError(errorMessage) {
  return {
    type: GET_CARS_ERROR,
    payload: errorMessage,
  };
}

// -------------- REMOVE_CAR_REQUEST -------------- 

 /** Action to remove car.
  * @param {string} carId - Car id
  * @param {string} userId - User id
  * @param {string} accessToken - access token
  * @return {any} message with status of the request  
  */
  export function removeCar(carId, userId, accessToken) {
    return {
      type: REMOVE_CAR_REQUEST,
      payload: {
        carId,
        userId,
        accessToken
      },
    };
  }

  /** On successfully removeCar update car object in store .
   * @param {string} statusMessage - Response message
   * @return {any} All cars
   */
  export function removeCarSuccess(statusMessage) {
    return {
      type: REMOVE_CAR_SUCCESS,
      payload: {
        statusMessage
      },
    };
  }

  /** On unsuccessfully removeCar update store and show error message .
   * @param {string} errorMessage - Error message
   */
  export function removeCarError(errorMessage) {
    return {
      type: REMOVE_CAR_ERROR,
      payload: errorMessage,
    };
  }

// -------------- EDIT_CAR_REQUEST -------------- 

/** Action to edit car.
  * @param {string} accessToken - accessToken
  * @param {string} city - City of the car
  * @param {string} color - Car's color
  * @param {string} condition - Car's condition
  * @param {string} engineType - Car's engineType
  * @param {string} gearBox - Car gearBox
  * @param {string} horsePower - horsePower
  * @param {string} id - User id
  * @param {string} make - Car's brand
  * @param {string} mileage - Car's mileage
  * @param {string} model - Car's model
  * @param {string} price - price
  * @param {string} user - user
  * @param {string} year - Car's year
  * @return {any} will return updated car object
  */
 export function editCar(accessToken,city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year) {
  return {
    type: EDIT_CAR_REQUEST,
    payload: {
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
    },
  };
}

/** On successfully editCar update car object in store .
   * @param {any} updatedCar - Updated car object
   * @return {any} updated Car
   */
  export function editCarSuccess(updatedCar) {
    return {
      type: EDIT_CAR_SUCCESS,
      payload: {
        updatedCar
      },
    };
  }

  /** On unsuccessfully editCar update store and show error message .
   * @param {string} errorMessage - Error message
   */
  export function editCarError(errorMessage) {
    return {
      type: EDIT_CAR_ERROR,
      payload: errorMessage,
    };
  }

// -------------- CREATE_CAR_REQUEST -------------- 

/** Action to create car.
  * @param {string} accessToken - accessToken
  * @param {string} city - City of the car
  * @param {string} color - Car's color
  * @param {string} condition - Car's condition
  * @param {string} engineType - Car's engineType
  * @param {string} gearBox - Car gearBox
  * @param {string} horsePower - horsePower
  * @param {string} id - User id
  * @param {string} make - Car's brand
  * @param {string} mileage - Car's mileage
  * @param {string} model - Car's model
  * @param {string} price - price
  * @param {string} user - user
  * @param {string} year - Car's year
  * @return {any} will return created car object
  */
 export function createCar(accessToken,city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year) {
  return {
    type: CREATE_CAR_REQUEST,
    payload: {
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
    },
  };
}

/** On successfully createCar update car object in store .
   * @param {any} createCar - create car object
   * @return {any} create Car
   */
  export function createCarSuccess(createCar) {
    return {
      type: CREATE_CAR_SUCCESS,
      payload: {
        createCar
      },
    };
  }

  /** On unsuccessfully createCar update store and show error message .
   * @param {string} errorMessage - Error message
   */
  export function createCarError(errorMessage) {
    return {
      type: CREATE_CAR_ERROR,
      payload: errorMessage,
    };
  }