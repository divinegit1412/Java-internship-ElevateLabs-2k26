import React, { useState } from 'react';

const Home = () => {
  const [originalUrl, setOriginalUrl] = useState('');
  const [shortUrl, setShortUrl] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const handleShorten = async (e) => {
    e.preventDefault();
    setError('');
    setShortUrl('');
    setIsLoading(true);

    try {
      const response = await fetch('https://java-internship-elevatelabs-2k26.onrender.com/divineLinks/shorten', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ originalUrl: originalUrl }),
      });

      if (!response.ok) {
        throw new Error('Failed to shorten URL. Please check your backend connection.');
      }

      const data = await response.text();
      setShortUrl(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-b from-slate-50 to-slate-100 font-sans text-slate-800 selection:bg-blue-200">
      

      <nav className="p-6 flex justify-between items-center max-w-5xl mx-auto">
        <div className="text-2xl font-extrabold text-blue-600 tracking-tighter">DivineLinks.</div>
        <div className="hidden md:flex space-x-8 text-sm font-semibold text-slate-600">
          <a href="#features" className="hover:text-blue-600 transition">Features</a>
          <a href="#api" className="hover:text-blue-600 transition">API Docs</a>
          <a href="https://github.com" target="_blank" rel="noreferrer" className="hover:text-blue-600 transition">GitHub</a>
        </div>
      </nav>

      <main className="max-w-4xl mx-auto px-6 pt-16 pb-24 text-center">
        <div className="inline-block mb-4 px-3 py-1 rounded-full bg-blue-100 text-blue-700 text-xs font-bold uppercase tracking-wider">
          v1.0 is now live
        </div>
        <h1 className="text-5xl md:text-6xl font-extrabold text-slate-900 mb-6 leading-tight">
          Make every <span className="text-transparent bg-clip-text bg-gradient-to-r from-blue-600 to-cyan-500">link</span> count.
        </h1>
        <p className="text-lg md:text-xl text-slate-600 mb-12 max-w-2xl mx-auto">
          Transform long, messy URLs into clean, memorable, and fast-redirecting short links. Built for developers, creators, and students.
        </p>
       
        <div id="shortener" className="bg-white p-2 sm:p-4 rounded-2xl shadow-xl shadow-blue-900/5 max-w-2xl mx-auto border border-slate-100">
          <form onSubmit={handleShorten} className="flex flex-col sm:flex-row gap-3">
            <input
              type="url"
              required
              placeholder="Paste your long link here..."
              className="flex-1 p-4 bg-slate-50 border-transparent rounded-xl focus:bg-white focus:border-blue-300 focus:ring-2 focus:ring-blue-100 transition outline-none"
              value={originalUrl}
              onChange={(e) => setOriginalUrl(e.target.value)}
            />
            <button
              type="submit"
              disabled={isLoading}
              className={`px-8 py-4 text-white rounded-xl font-bold tracking-wide transition duration-200 shadow-lg ${
                isLoading 
                  ? 'bg-blue-400 cursor-not-allowed' 
                  : 'bg-blue-600 hover:bg-blue-700 hover:shadow-blue-600/30 hover:-translate-y-0.5'
              }`}
            >
              {isLoading ? 'Processing...' : 'Shorten'}
            </button>
          </form>


          {error && (
            <div className="mt-4 p-4 bg-red-50 text-red-600 rounded-xl text-sm font-medium animate-pulse">
              {error}
            </div>
          )}

          {shortUrl && (
            <div className="mt-4 p-6 bg-blue-50 border border-blue-100 rounded-xl flex flex-col sm:flex-row items-center justify-between gap-4">
              <div className="text-left">
                <p className="text-blue-800 font-semibold mb-1">Your short link is ready!</p>
                <a
                  href={shortUrl}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-blue-600 font-bold hover:underline break-all text-lg"
                >
                  {shortUrl}
                </a>
              </div>
              <button 
                onClick={() => navigator.clipboard.writeText(shortUrl)}
                className="px-4 py-2 bg-white text-blue-600 border border-blue-200 rounded-lg text-sm font-bold hover:bg-blue-50 transition"
              >
                Copy Link
              </button>
            </div>
          )}
        </div>

      
        <div id="features" className="grid grid-cols-1 md:grid-cols-3 gap-8 mt-24 text-left">
          <div>
            <div className="w-12 h-12 bg-blue-100 text-blue-600 rounded-xl flex items-center justify-center text-xl font-black mb-4">⚡</div>
            <h3 className="text-lg font-bold text-slate-900 mb-2">Lightning Fast</h3>
            <p className="text-slate-600 text-sm">Powered by a robust Spring Boot backend to ensure instant redirects.</p>
          </div>
          <div>
            <div className="w-12 h-12 bg-blue-100 text-blue-600 rounded-xl flex items-center justify-center text-xl font-black mb-4">🔒</div>
            <h3 className="text-lg font-bold text-slate-900 mb-2">Secure Base62</h3>
            <p className="text-slate-600 text-sm">Every link is securely encoded using industry-standard Base62 generation.</p>
          </div>
          <div>
            <div className="w-12 h-12 bg-blue-100 text-blue-600 rounded-xl flex items-center justify-center text-xl font-black mb-4">📊</div>
            <h3 className="text-lg font-bold text-slate-900 mb-2">Click Analytics</h3>
            <p className="text-slate-600 text-sm">Track how many times your links are clicked in real-time.</p>
          </div>
        </div>
      </main>

   
      <footer className="py-8 text-center text-sm font-medium text-slate-400 border-t border-slate-200">
        <p>Built with Spring Boot & React by Mradul</p>
      </footer>

    </div>
  );
};

export default Home;