

interface FoodProvider {
  id: string;
  name: string;
  address: string;
  phone: string;
  email: string;
  description: string;
  createdAt: Date;
  modifiedAt: Date;
}


export interface Food {
  id: string;
  name: string;
  type: string;
  ingredients: string[];
  price: number;
  cookTime?: number;
  provider: FoodProvider;
  createdAt: Date;
  modifiedAt: Date;
}

export interface FoodOrder {
  id: string;
  date: Date;
  discount: number;
  food: Food ;
  createdAt: Date;
  modifiedAt: Date;
}
