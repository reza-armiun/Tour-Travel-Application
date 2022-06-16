import {Address} from "./Address";
import {AccommodationOrder} from "./AccommodationOrder";
import {VehicleOrder} from "./VehicleOrder";
import {FoodOrder} from "./FoodOrder";
import {Activity} from "./Activity";


interface TourismManager {
  name: string;
  email: string;
  phone: string;
  address: Address;
  nationalId: number;
}

export interface SchedulePlan {
  id: string;
  name: string;
  startTime: Date;
  arrivalTime: Date;
  source: Address;
  destination: Address;
  accommodationOrder: AccommodationOrder;
  foodOrders: FoodOrder[];
  vehicleOrders: VehicleOrder[];
  activities: Activity[];
  createdAt: Date;
  modifiedAte:  Date;
}

export interface Tour {
  id?: string;
  name: string;
  type: string;
  guid: string;
  description: string;
  imgUrl: string;
  rating: number;
  price: number;
  date: string;
  categories: string[];
  tourismManager: TourismManager;
  schedulePlans: SchedulePlan[] ;
  createdAt: Date;
  modifiedAte:  Date;
}
