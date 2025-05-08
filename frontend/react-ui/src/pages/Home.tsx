import {Header, Footer, Hero, Navbar} from '../components/index';
function Home() {
  return (
    <>
        <div className="relative m-0 h-[3000px] w-screen bg-sky-100">
          <Navbar/>
          <Header/>
          <Hero/>
          <Footer/>
        </div>
       
    </>
  )
}

export default Home