import axios from 'axios';
import { CAR_SERVICE } from './config';

export const api = {
  deleteCar: async function(carId,userId, accessToken) {
    return axios.delete(CAR_SERVICE + "/" + carId + "/" + userId,{
      headers: {
        'Authorization': 'Bearer ' + accessToken,
        'Content-Type': 'application/json'
      },
    });
  },
};



