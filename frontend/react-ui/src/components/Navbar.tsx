import {Link } from 'react-router-dom';

function Navbar() {
  return (
    <>
        <div className="ml-20 h-20 w-[1200px] absolute inset-x-0 top-96 pl-72 border-t-8 border-neutral-900">
          <nav className="text-stone-950 p-4 flex space-x-60">
            <Link to="/" className="hover:text-gray-950">Home</Link>
            <Link to="/notes" className="hover:text-gray-50">Notes</Link>
            <Link to="/community" className="hover:text-gray-50">Community</Link>
          </nav>
        </div>
    </>
  )
}

export default Navbar