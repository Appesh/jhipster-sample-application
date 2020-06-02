import { Moment } from 'moment';
import { ICategory } from 'app/shared/model/category.model';

export interface IProduct {
  id?: number;
  title?: string;
  keywords?: string;
  description?: string;
  rating?: number;
  dateAdded?: string;
  dateModified?: string;
  categories?: ICategory[];
}

export const defaultValue: Readonly<IProduct> = {};
