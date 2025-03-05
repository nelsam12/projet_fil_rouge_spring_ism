export interface ProduitCatalogue {
  id: number;
  name: string;
  image: string;
  oldPrice: number;
  newPrice: number;
  sold: boolean;
  notation : number; // On va créer un tableau à partir de ça
}
