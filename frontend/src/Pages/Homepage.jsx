import React from "react";
import HomeCarousel from "../customer/Components/Carousel/HomeCarousel";
import HomeProductCarousel from "../customer/Components/Carousel/HomeProductCarousel";
import { mens_kurta } from "../data/Men/men_kurta";
import { mensShoesPage1 } from "../data/shoes";
import { sareePage1 } from "../data/Saree/page1";
import { gounsPage1 } from "../data/Gouns/gouns";
import { dressPage1 } from "../data/dress/page1";
import { kurtaPage1 } from "../data/Kurta/kurta";
import { women_top } from "../data/Women/women_top";
import { mensPantsPage1 } from "../data/pants/men_page1";
import Product from "../customer/Components/Product/Product";
import ProductDetails from "../customer/Components/Product/ProductDetails";
const Homepage = () => {
  return (
    <div>
      <div>
        <HomeCarousel />
      </div>
      <div>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta} />
        <HomeProductCarousel data={mensShoesPage1} section={"Men's Shoes"} />
        <HomeProductCarousel data={women_top} section={"Women's Top"} />
        <HomeProductCarousel data={sareePage1} section={"Saree"} />
        <HomeProductCarousel data={dressPage1} section={"Dress"} />
        <HomeProductCarousel data={gounsPage1} section={"Women's Gouns"} />
        <HomeProductCarousel data={kurtaPage1} section={"Women's Kurtas"} />
        <HomeProductCarousel data={mensPantsPage1} section={"Men's Pants"} />
      </div>
    </div>
  );
};

export default Homepage;
