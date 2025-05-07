import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import {Navbar} from './components/index';
import {Home, About, Content, User} from './pages/index'

function App() {
  
  return (
    <>
     <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/user" element={<User />} />
        <Route path="/content" element={<Content />} />
      </Routes>
    </Router>
    </>
  )
}

export default App
