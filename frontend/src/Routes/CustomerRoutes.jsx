import React from "react";
import { Route, Routes, useLocation } from "react-router-dom";
import Homepage from "../Pages/Homepage";
import Navigation from '../customer/Components/Navigation/Navigation'
import {ThemeProvider} from "@mui/material/styles"
import Cart from '../customer/Components/Cart/Cart'
import Product from "../customer/Components/Product/Product";
import {customerTheme} from '../Admin/theme/customThemes'
import Privacy from '../Pages/Privacy'
import Contact from '../Pages/Contact'
import About from '../Pages/About'
import TermsAndConditions from '../Pages/TermsAndConditions'
import ProductDetails from "../customer/Components/Product/ProductDetails";
import Order from "../customer/Components/Order/Order";
import OrderDetails from "../customer/Components/Order/OrderDetails";
import RateProduct from "../customer/Components/Product/RateProduct";
import CheckOut from '../customer/Components/Checkout/Checkout'
import Footer from '../customer/Components/Footer'
import PaymentSuccess from "../customer/Components/PaymentSuccess";
const CustomerRoutes = () => {
  const location=useLocation( );
  const showNavigation=location.pathname!=="*";
  return (
    <div>
      <ThemeProvider theme={customerTheme}>
        {showNavigation && <Navigation />}
        <Routes>
          <Route path="/login" element={<Homepage />}></Route>
          <Route path="/register" element={<Homepage />}></Route>

          <Route path="/" element={<Homepage />}></Route>
          <Route path="/home" element={<Homepage />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/privaciy-policy" element={<Privacy/>}></Route>
          <Route path="/terms-condition" element={<TermsAndConditions />}></Route>
          <Route path="/contact" element={<Contact />}></Route>
          <Route
            path="/:lavelOne/:lavelTwo/:lavelThree"
            element={<Product />}
          ></Route>
          <Route
            path="/product/:productId"
            element={<ProductDetails />}
          ></Route>
          <Route path="/cart" element={<Cart />}></Route>
          <Route path="/account/order" element={<Order />}></Route>
          <Route
            path="/account/order/:orderId"
            element={<OrderDetails />}
          ></Route>
          <Route
            path="/account/rate/:productId"
            element={<RateProduct />}
          ></Route>
          <Route path="/checkout" element={<CheckOut />}></Route>
          <Route path="/payment/:orderId" element={<PaymentSuccess />}></Route>
          {/* <Route path="*" element={<NotFound />} /> */}
        </Routes>
        <Footer />
      </ThemeProvider>
    </div>
  );
};

export default CustomerRoutes;
