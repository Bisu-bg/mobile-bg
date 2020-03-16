import axios from 'axios';
import { CAR_SERVICE } from './config';

const MOCK_CREATE_CAR_RESPONSE = {
  data:[
    {
      "id": "b5af8461-3f44-4f88-a2d6-5a10ec0a0d6e",
      "make": "Mazda",
      "model": "5",
      "year": 2015,
      "engineType": "DIESEL",
      "gearBox": "MANUAL",
      "condition": "NEW",
      "horsePower": 150,
      "color": "Black",
      "price": 25000,
      "city": "Sofia",
      "mileage": 150000,
      "user": {
        "id": "e9818f61-df27-4236-b0e9-0fe1404cb6a9",
        "username": "StefanVadev",
        "password": "123456",
        "firstName": "Stefan",
        "lastName": "Vadev"
      },
      "extras": "Leather Interior, Parktronic"
    }
  ]
}


export const api = {
  createCar: async function(accessToken,city,color,condition,engineType,extras,gearBox, horsePower,id,make,mileage,model,price,user,year) {
    return axios.post(CAR_SERVICE,  {
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
