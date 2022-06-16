import {Address} from "./Address";


interface AccommodationProvider {
  id: string;
  name: string;
  phone: string;
  email: string;
  description: string;
  createdAt: Date;
  modifiedAte: Date;
}


interface Accommodation {
  id: string;
  type: string;
  name: string;
  price: number;
  checkIn: Date;
  checkOut: Date;
  accommodationProvider: AccommodationProvider;
  address: Address;
  createdAt: Date;
  modifiedAte:  Date;
}

export interface AccommodationOrder {
  id: string;
  date: Date;
  discount: number;
  createdAt: Date;
  modifiedAte:  Date;
  accommodation: Accommodation;
}
