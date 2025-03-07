export interface ProduitCatalogue {
  id: number;
  name: string;
  image: string;
  description?: string;
  oldPrice: number;
  newPrice: number;
  sold: boolean;
  notation : number; // On va créer un tableau à partir de ça
}

export interface ProduitDetail {
  produit : ProduitCatalogue;
  relatedProducts : ProduitCatalogue[]
}