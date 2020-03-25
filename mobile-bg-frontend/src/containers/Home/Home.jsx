import React, { useEffect } from 'react';
import MaterialTable from 'material-table';
import Header from '../../components/Header/Header.jsx'
import {tableTitleColumns} from '../../common/tableTitleColumns';
import {isEmpty} from 'lodash';
//Redux && actions
import { getCars, editCar, removeCar, createCar } from '../../containers/Home/actions';
import { useSelector, useDispatch } from 'react-redux';

export default function MaterialTableDemo() {
  const dispatch = useDispatch();
  /** All details of robot {alarms,events,id,name,type} */
  const { cars } = useSelector(state => state.getCars);
  /** Current user info */
  const { currentUser, userId, accessToken, firstName, lastName } = useSelector(state => state.userSession);
  // Contains list with all cars
  const [allCars, setCars] = React.useState(cars)

  const [selsectedRow, setSelectedRow] =React.useState([])
 
  /** Create request to get all Cars */
  useEffect(() => {
      dispatch(getCars());
      setCars(cars)
  },[!isEmpty(cars)])

  /** Update car request */
  function onEdit(newData, oldData){
    const {city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year } = newData

    setCars(prevState => {
      const data = [...prevState];
      data[data.indexOf(oldData)] = newData;
      dispatch(editCar(accessToken,city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,user,year)) 
      return data;
    });
  }   

  /** Remove car request */
  function deleteCar(oldData){
    dispatch(removeCar(oldData.id,userId,accessToken))
  }

  /** Create new car request */
  function createNewCar(newData){
    const {city,color,condition,engineType,extras,gearBox,horsePower,id,make,mileage,model,price,year } = newData;
    const user = {
        id: userId,
        username: currentUser,
        password: null,
        firstName: firstName,
        lastName: lastName
    }
    dispatch(createCar(accessToken,city,color,condition,engineType,extras,gearBox, horsePower,id,make,mileage,model,price,user,year))
  }

  return (
    <div>
      {console.log('selsectedRow ',selsectedRow)}
      <Header/>
      <MaterialTable
        title="Simple Cars"
        columns={tableTitleColumns}
        data={allCars}
        options={{
          selection: true
        }}
        onSelectionChange={(rows) => setSelectedRow(rows) }
        editable={{
          onRowAdd: currentUser ? newData =>
            new Promise(resolve => {
              setTimeout(() => {
                resolve();
                setCars(prevState => {
                  const data = [...prevState];
                  data.push(newData);
                  createNewCar(newData)
                  return  data ;
                });
              }, 600);
            }) : null, 
          onRowUpdate: currentUser ? (newData, oldData) => 
            new Promise(resolve => {
              setTimeout(() => {
                resolve();
                if (oldData) {
                  onEdit(newData, oldData)
                }
              }, 600);
            }): null,
          onRowDelete: currentUser ? oldData =>
            new Promise(resolve => {
              setTimeout(() => {
                resolve();
                setCars(prevState => {
                  const data = [...prevState];
                  data.splice(data.indexOf(oldData), 1);
                  deleteCar(oldData)
                  return  data;
                });
              }, 600);
            }) : null,
        }}
      />

    </div>
  );
}
