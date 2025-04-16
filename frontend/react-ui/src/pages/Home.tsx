import {Header, Navbar, Footer, Hero} from '../components/index';
function Home() {
  return (
    <>
        
        <Navbar name="NavigationBar" type="component"/>
        <Header name="HeaderSection" type="component"/>
        <Hero name="HeroSection" type="component"/>
        <Footer name="FooterSection" type="component"/>
    </>
  )
}

export default Home