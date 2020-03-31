import axios from 'axios';
import { CAR_SERVICE } from './config';

export const api = {
  
  editCar: async function(accessToken,city,color,condition,engineType,extras,gearBox, horsePower,id,make,mileage,model,price,user,year,userId) {
    return axios.put(CAR_SERVICE + "/" + userId,
      {
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
      }, {
      headers: {
        'Authorization': 'Bearer ' + accessToken,
        'Content-Type': 'application/json'
      }, 
    }   
    );
  },
};



