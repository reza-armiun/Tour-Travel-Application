import {Address} from "./Address";


interface VehicleProvider {
  id: string
  name: string;
  phone: string;
  email: string;
  description: string;
  address: Address;
  createdAt: Date;
  modifiedAt: Date;
}

interface Vehicle {
  id: string
  name: string;
  type: string;
  fromStation: string;
  toStation: string;
  ticketNumber: number;
  price: number;
  departure: Date;
  arrival: Date;
  vehicleProvider: VehicleProvider;
  createdAt: Date;
  modifiedAt: Date;
}

export interface VehicleOrder {
  id: string
  name : string;
  discount: number;
  vehicle: Vehicle;
  createdAt: Date;
  modifiedAt: Date;
}
