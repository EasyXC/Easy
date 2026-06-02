package com.easy.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.easy.demo.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupClickListeners()
    }

    private fun setupUI() {
        binding.tvVersion.text = getString(R.string.label_version, "1.0.0")
        binding.tvAuthor.text = getString(R.string.label_author, "EasyTeam")
        
        binding.tvAppName.text = getString(R.string.app_name)
    }

    private fun setupClickListeners() {
        binding.tvWebsite.setOnClickListener {
            // Demo 版本：仅显示提示，不实际打开网页
            // 实际应用中这里会打开网页
        }
        
        binding.btnCheckUpdate.setOnClickListener {
            // Demo 版本：仅显示提示，不实际检查更新
            // 实际应用中这里会检查更新
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = AboutFragment()
    }
}