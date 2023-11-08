import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import { homeCarouselData } from "./HomeCarouselData";

const HomeCarousel = () => {
  const items = homeCarouselData.map((item) => (
    <img
      role="presentation"
      className="cursor-pointer"
      src={item.image}
      alt=""
    />
  ));

  return (
    <AliceCarousel
      autoPlay
      autoPlayInterval={4000}
      infinite
      disableButtonsControls
      mouseTracking
      items={items}
    />
  );
};
export default HomeCarousel;
