import React from 'react'
import HomeCarousel from '../customer/Components/Carousel/HomeCarousel'
import HomeProductCarousel from '../customer/Components/Carousel/HomeProductCarousel'
import {mens_kurta} from '../data/Men/men_kurta'
const Homepage = () => {
  return (
    <div>
    <HomeCarousel/>
    <div>
        home
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
        <HomeProductCarousel section={"Men's kurta"} data={mens_kurta}/>
    </div>
    </div>
  )
}

export default Homepage