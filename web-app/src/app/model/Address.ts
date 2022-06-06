

interface Country {
  id: string
  name: string;
  countryCode: number;
  createdAt: Date;
  modifiedAt: Date;
}

interface City {
  id: string;
  name: string;
  zipCode: number;
  country: Country;
  createdAt: Date;
  modifiedAt: Date;
}

export interface Address {
  id: string;
  street: string;
  postalCode: string;
  city: City;
  createdAt: Date;
  modifiedAt: Date;
}
