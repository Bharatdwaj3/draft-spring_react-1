import {Navbar, Header, Footer, Hero} from '../components/index';
function Content() {
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

export default Content
